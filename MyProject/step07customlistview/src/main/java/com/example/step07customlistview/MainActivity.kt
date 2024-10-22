package com.example.step07customlistview

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
/*
     [ json 문자열 사용하기 ]

     [ ]  =>  JSONArray  객체로 변환
     { }  =>  JSONObject  객체로 변환
 */
class MainActivity : AppCompatActivity(), OnItemLongClickListener {
    //늦게 초기화 되는 필드 정의
    lateinit var list:MutableList<MemberDto>
    lateinit var adapter: MemberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //MutableList 객체 생성
        list = mutableListOf()

        //ListView 에 연결할 아답타 객체 생성해서
        adapter = MemberAdapter(this, R.layout.listview_cell, list)
        //ListView 에 연결하기
        val listView:ListView = findViewById(R.id.listView)
        listView.adapter = adapter
        //ListView 에 아이템을 오랫동안 클릭하고 있을 때 동작할 리스너 등록
        listView.setOnItemLongClickListener(this)

        //EditText 객체의 참조값
        val inputName:EditText = findViewById(R.id.inputName)
        val inputAddr:EditText = findViewById(R.id.inputAddr)
        //버튼의 참조값 얻어와서 리스너 등록
        val addBtn:Button = findViewById(R.id.addBtn)
        addBtn.setOnClickListener{
            //입력한 이름과 주소를 읽어와서
            val name=inputName.text.toString()
            val addr=inputAddr.text.toString()
            val dto=MemberDto(0, name, addr)
            //Post 방식으로 서버에 전송하기
            lifecycleScope.launch(Dispatchers.Main) {
                //입력한 이름과 주소를 json 문자열로 만든다. (Map 혹은 Dto 를 넣어주면 자동으로 json 으로변경)
                val json=Gson().toJson(dto)
                //RestApiClient 유틸리티를 이용해서 서버에 전송하고 응답된 문자열 읽어오기
                val result = RestApiClient.post("http://192.168.0.181:8888/members", json)
                //응답된 문자열을 Toast 메세지로 출력해보기
                Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()
                //데이터를 추가한 이후에 다시 호출
                refresh()
            }
        }
        //onCreate() 메소드에서 한번 호출
        refresh()
    }

    //ListView 를 refresh 하는 메소드
    fun refresh(){
        // http://192.168.0.181:8888/members 요청을 해서 응답되는 json 문자열을 Log 창에 출력해 보세요
        lifecycleScope.launch(Dispatchers.Main) {
            val result = RestApiClient.get("http://192.168.0.181:8888/members")
            Log.d("MaiActivity", result)
            //일단 모두 삭제한 다음 다시 데이터를 담는다.
            list.clear()

            //응답받은 문자열의 형식이 [{},{},{}...] 이기 때문에 해당 문자열을 이용해서 JSONArray 객체를 생성
            val array=JSONArray(result)
            //반복문 돌면서
            for(i in 0 until array.length()){
                //i 번째 JSONObject 객체를 얻어와서
                val tmp:JSONObject = array.getJSONObject(i)
                //MemberDto 에 num, name, addr 을 담는다.
                val mem = MemberDto().apply {
                    num=tmp.getInt("num")
                    name=tmp.getString("name")
                    addr=tmp.getString("addr")
                }
                //MutableList 에 누적시킨다.
                list.add(mem)
            }
            //반복문 돌고나서 Adapter 에 데이터가 수정되었다고 알린다. (UI 업데이트를 위해)
            adapter.notifyDataSetChanged()
        }
    }



    override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, index: Int, id: Long): Boolean {
        // index 는 클릭한 셀의 인덱스, id 는 클릭한 셀의 primary key
        AlertDialog.Builder(this)
            .setTitle("삭제 하시겠습니까?")
            .setPositiveButton("네") { a, b ->
                lifecycleScope.launch(Dispatchers.Main) {
                    val result = RestApiClient.delete("http://192.168.0.181:8888/members/$id")
                    // {"isSuccess":true} 형식의 json 문자열을 이용해서 객체 생성
                    val obj = JSONObject(result)
                    // 작업 성공 여부를 얻어와서
                    val isSuccess = obj.getBoolean("isSuccess")
                    // 만일 성공이면
                    if (isSuccess){
                        //새로고침
                        refresh()
                    }

                }
            }
            .setNeutralButton("아니요", null)
            .create()
            .show()
        return true
    }

}






