import java.util.ArrayList;
import java.util.List;

class Slide {
    private String text;

    public Slide(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class Presentation {
    private List<Slide> slides = new ArrayList<>();
    
    public void addSlide(Slide slide) {
        slides.add(slide);
    }

    public void export(PresentationFormat format) {
        if (format == PresentationFormat.PDF) {
            var pdf = new PdfDocument();
            pdf.addPage("Copyright");
            for (Slide slide: slides) 
                pdf.addPage(slide.getText());
            
        }
        else if (format == PresentationFormat.MOVIE) {
            var movie = new Movie();
            movie.addFrame("Copyright", 2);
            for (Slide slide: slides) 
                movie.addFrame(slide.getText(), 2);
        }
    }
}

class Movie {
    public void addFrame(String text, int duration) {
        System.out.println("Adding frame to movie");
    }
}

enum PresentationFormat {
    PDF,
    IMAGE,
    POWERPOINT,
    MOVIE
}

class PdfDocument {
    public void addPage(String text) {
        System.out.println("Adding page to PDF");
    }
}

public class Builder {
    public static void main(String[] args) {
       
    }
}
