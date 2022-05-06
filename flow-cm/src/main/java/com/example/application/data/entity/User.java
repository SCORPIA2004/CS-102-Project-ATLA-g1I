package com.example.application.data.entity;

import javax.persistence.Entity;
import javax.sound.midi.Instrument;
import javax.validation.constraints.NotEmpty;

import com.vaadin.flow.component.html.Image;
@Entity
public class User{

    @NotEmpty
    private String username = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private Image pfp = null;

    private int gamesPlayed = 0;

    private int gamesWon = 0;

    private int masteryLevel = 0;

    private Instrument favInstrument = null;
    
    private int rank = 0;
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
