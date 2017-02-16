package com.five.beans;

public class Game {

	private int [][]array = new int[19][19];
	private String [] playerList = new String[361];
	
	public int[][] getArray() {
		return array;
	}
	public void setArray(int[][] arr) {
		this.array = arr;
	}
	public String[] getPlayerList() {
		return playerList;
	}
	public void setPlayerList(String[] playerList) {
		this.playerList = playerList;
	}
	
}
