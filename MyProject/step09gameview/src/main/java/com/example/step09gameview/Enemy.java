package com.example.step09gameview;

public class Enemy {
    public int x, y; //적기의 좌표
    public int type; //적기의 type 0 or 1
    public boolean isDead;//배열에서 제거할지 여부
    public int energy;//에너지
    public int imageIndex; //적기의 이미지 인덱스 (애니매이션 효과를 주기위해)
}