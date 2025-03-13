package DesignPatterns.Plan;

class Image {


}

interface Filter {
    void apply(Image image);
}

class VividFilter implements Filter {
    @Override
    public void apply(Image image) {
        System.out.println("Applying Vivid Filter");
    }
}

class ImageView {
    private Image image;

    public ImageView(Image image) {
        this.image = image;
    }

    public void apply(Filter filter) {
        filter.apply(image);    
    }
}


class Caramel {
    public void init() {
        System.out.println("Init Caramel");
    }
    
    public void render(Image image) {
        System.out.println("Applying Caramel Filter");
    }
}

class CaramelAdapter implements Filter {
    private Caramel caramel;

    public CaramelAdapter(Caramel caramel) {
        this.caramel = caramel;
    }

    @Override
    public void apply(Image image) {
        caramel.init();
        caramel.render(image);
    }
}

public class Adapter {
    public static void main(String[] args) {
       var imageView = new ImageView(new Image());
       imageView.apply(new VividFilter());


       var caramel = new Caramel();
       imageView.apply(new CaramelAdapter(caramel));
}
}