package de.skerkewitz.ksrc.parse.ast.nodes;

import de.skerkewitz.ksrc.common.SourceLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AstNode {

  public final SourceLocation srcLocation;

  /** The children of this node. */
  private final List<AstNode> children = new ArrayList<>(2);

  public AstNode(SourceLocation srcLocation) {
    this.srcLocation = srcLocation;
  }

  protected void addChild(AstNode node) {
    this.children.add(node);
  }

  public int getChildCount() {
    return this.children.size();
  }

  public List<AstNode> getChildren() {
    return Collections.unmodifiableList(this.children);
  }

  public AstNode getChildAt(int index) {
    return this.children.get(index);
  }
}
