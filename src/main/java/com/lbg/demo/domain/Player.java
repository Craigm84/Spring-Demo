package com.lbg.demo.domain;

public class Player {

	public String player;

	public String club;

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return "Players [Player = " + player + ", Club = " + club + "]";
	}

}
