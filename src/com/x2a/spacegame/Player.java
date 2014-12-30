package com.x2a.spacegame;

import com.x2a.math.Vector2;
import com.x2a.scene.InputSprite;
import com.x2a.scene.Node;
import com.x2a.spacegame.player.PlayerGround;
import com.x2a.spacegame.player.PlayerSpace;
import com.x2a.spacegame.player.PlayerWarp;

import java.util.Vector;

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
        playerSpace = new PlayerSpace();

        state = PlayerState.WARP;
    }

    public void setState(PlayerState state) {
        getSubPlayer(this.state).deactivate();
        this.state = state;
        getSubPlayer(this.state).activate();
    }

    public PlayerState getState() {
        return state;
    }

    @Override
    public void update(float timeElapsed) {
        getSubPlayer(state).update(timeElapsed);
    }

    @Override
    public void draw() {
        getSubPlayer(state).draw();
    }

    private InputSprite getSubPlayer(PlayerState state) {
        switch (state) {
            case WARP:
                return playerWarp;
            case SPACE:
                return playerSpace;
            case GROUND:
                return playerGround;
        }
        return null;
    }

    public void setPosition(Vector2 position) {
        getSubPlayer(state).setPosition(position);
    }

    public Vector2 getPosition(Vector2 position) {
        return getSubPlayer(state).getPosition();
    }



}
