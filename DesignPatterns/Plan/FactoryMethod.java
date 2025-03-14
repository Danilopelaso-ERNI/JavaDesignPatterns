package DesignPatterns.Plan;

import java.util.Map;
import java.util.HashMap;

interface ViewEngine {
    String render(String viewName, Map<String, Object> context);
}

class MatchaViewEngine implements ViewEngine {
    @Override
    public String render(String viewName, Map<String, Object> context) {
        return "View rendered Matcha";
    }
}

abstract class Controller {
    public void render(String viewName, Map<String, Object> context) {
        var engine = new MatchaViewEngine();
        var html = engine.render(viewName, context);
        System.out.println(html);
    }

    protected abstract ViewEngine getViewEngine();
}

class ProductsController extends Controller {
    @Override
    protected ViewEngine getViewEngine() {
        return new MatchaViewEngine();
    }

    public void listProducts() {
        Map<String, Object> context = new HashMap<>();
        render("products.html", context);
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
         ProductsController controller = new ProductsController();
         controller.listProducts();
    }
}
