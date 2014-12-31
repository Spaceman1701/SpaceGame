package com.x2a.spacegame;

import com.x2a.game.Game;
import com.x2a.input.KeyEventData;
import com.x2a.input.KeyEventListener;
import com.x2a.input.KeyEventType;
import com.x2a.input.SafeInputUtil;
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

    private Game game;

    public Player(Game game) {
        playerWarp = new PlayerWarp();
        playerSpace = new PlayerSpace(this);

        state = PlayerState.WARP;

        this.game = game;

        SafeInputUtil.getInstance().registerKeyEventListener(new KeyEventListener() {
            @Override
            public void onKeyEvent(KeyEventData data) {
               // if (isActivated()) {
                    if (data.getEventType() == KeyEventType.KEY_PRESSED && data.getKeyChar() == Character.toLowerCase('x')) {
                        System.out.println(state);
                    }
               // }
            }
        });
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

    public Vector2 getPosition() {
        System.out.println(state);
        return getSubPlayer(state).getPosition();
    }

    public Vector2 getPosition(PlayerState state) {
        return getSubPlayer(state).getPosition();
    }

    public Game getGame() {
        return game;
    }

}
