package DesignPatterns.Plan;

import java.util.ArrayList;
import java.util.List;

interface HtmlNode {
    void highlight();
    void execute(Operation operation);
}

class HtmlDocument {
    private List<HtmlNode> nodes = new ArrayList<>();

        public void add(HtmlNode node) {
            nodes.add(node);
        }

       public void execute(Operation operation) {
           for (var node : nodes)
               node.execute(operation);
       }

}

class HeadingNode implements HtmlNode {
 

    @Override
    public void highlight() {
        System.out.println("highlighting heading");
    }


    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}

class AnchorNode implements HtmlNode {

    @Override
    public void highlight() {
        System.out.println("highlighting anchor");
    }
   @Override
   public void execute(Operation operation) {
       operation.apply(this);
   }
}

interface Operation {
    void apply(HeadingNode heading);
    void apply(AnchorNode anchor);
}


class HighlightOperation implements Operation {
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("highlighting heading");
    }

    @Override
    public void apply(AnchorNode anchor) {
        System.out.println("highlighting anchor");
    }
}
public class Visitor {
    public static void main(String[] args) {
        var document = new HtmlDocument();
        document.add(new HeadingNode());
        document.add(new AnchorNode());
        document.execute(new HighlightOperation());

    }
}
