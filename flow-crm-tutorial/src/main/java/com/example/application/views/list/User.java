package com.example.application.views.list;
import java.awt.Image;
public class User {
    

    // variables
    String username;
    String password;
    Image pfp;
    int gamesPlayed;
    int gamesWon;
    int masteryLevel;
    Instrument favInstrument;
    int rank;

    public String getUsername() {
		return this.username;
	}

    public void setUsername(String username) {
		this.username = username;
	}

    public String getPassword() {
		return this.password;
	}

    public void setPassword(String password) {
		this.password = password;
	}

    public Image getPfp() {
		return this.pfp;
	}

    public void setPfp(Image pfp) {
		this.pfp = pfp;
	}

    public int getGamesPlayed() {
		return this.gamesPlayed;
	}

    public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

    public int getGamesWon() {
		return this.gamesWon;
	}

    public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

    public int getMasteryLevel() {
		return this.masteryLevel;
	}

    public void setMasteryLevel(int masteryLevel) {
		this.masteryLevel = masteryLevel;
	}

    public Instrument getFavInstrument() {
		return this.favInstrument;
	}

    public void setFavInstrument(Instrument favInstrument) {
		this.favInstrument = favInstrument;
	}

    public int getRank() {
		return this.rank;
	}

    public void setRank(int rank) {
		this.rank = rank;
	}



}
