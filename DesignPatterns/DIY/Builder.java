package DesignPatterns.DIY;
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

    public void export(PresentationBuilder builder) {
        builder.addTitleSlide("Copyright");
        for (Slide slide : slides) {
            builder.addSlide(slide);
        }
    }
}

interface PresentationBuilder {
    void addTitleSlide(String title);
    void addSlide(Slide slide);
}

class PdfBuilder implements PresentationBuilder {
    private PdfDocument pdf = new PdfDocument();

    @Override
    public void addTitleSlide(String title) {
        pdf.addPage(title);
    }

    @Override
    public void addSlide(Slide slide) {
        pdf.addPage(slide.getText());
    }

    public PdfDocument getPdfDocument() {
        return pdf;
    }
}

class MovieBuilder implements PresentationBuilder {
    private Movie movie = new Movie();

    @Override
    public void addTitleSlide(String title) {
        movie.addFrame(title, 2);
    }

    @Override
    public void addSlide(Slide slide) {
        movie.addFrame(slide.getText(), 2);
    }

    public Movie getMovie() {
        return movie;
    }
}

class Movie {
    public void addFrame(String text, int duration) {
        System.out.println("Adding frame to movie: " + text + " for " + duration + " seconds");
    }
}

class PdfDocument {
    public void addPage(String text) {
        System.out.println("Adding page to PDF: " + text);
    }
}

public class Builder {
    public static void main(String[] args) {
        Presentation presentation = new Presentation();
        presentation.addSlide(new Slide("Slide 1"));
        presentation.addSlide(new Slide("Slide 2"));

        PdfBuilder pdfBuilder = new PdfBuilder();
        presentation.export(pdfBuilder);
        System.out.println("PDF document created.");

        MovieBuilder movieBuilder = new MovieBuilder();
        presentation.export(movieBuilder);
        movieBuilder.getMovie();
        System.out.println("Movie created.");
    }
}