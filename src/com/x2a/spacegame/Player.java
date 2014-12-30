package com.x2a.spacegame;

import com.x2a.scene.Node;
import com.x2a.spacegame.player.PlayerGround;
import com.x2a.spacegame.player.PlayerSpace;
import com.x2a.spacegame.player.PlayerWarp;

/**
 * Created by Ethan on 12/29/2014.
 */
public class Player extends Node{

    public enum PlayerState {
        GROUND, SPACE, WARP;
    }

    private PlayerGround playerGround;
    private PlayerSpace playerSpace;
    private PlayerWarp playerWarp;

    private PlayerState state;

    public Player() {
        playerWarp = new PlayerWarp();

        state = PlayerState.SPACE;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public PlayerState getState() {
        return state;
    }



}
