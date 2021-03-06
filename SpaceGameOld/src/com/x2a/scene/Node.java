package com.x2a.scene;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 12/28/2014.
 */
public class Node {

    private Node parent;
    private List<Node> children;

    private boolean activated;

    public Node() {
        this(null);
    }

    public Node(Node parent) {
        this.parent = parent;
        children = new ArrayList<Node>();
    }

    public List<Node> getChildren() {
        return children;
    }

    public void draw() {
        children.forEach((Node child) -> child.draw());
    }

    public void update(float timeElapsed) {
        children.forEach((Node child) -> child.update(timeElapsed));
    }

    protected void onActivation() {
        children.forEach((Node child) -> child.onActivation());
        activated = true;
    }

    protected void onDeactivation() {
        children.forEach((Node child) -> child.onDeactivation());
        activated = false;
    }

    public boolean isActivated() {
        return activated;
    }

    public void activate() {
        onActivation();
    }

    public void deactivate() {
        onDeactivation();
    }

}
