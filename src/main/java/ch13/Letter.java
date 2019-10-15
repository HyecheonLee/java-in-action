package ch13;

import java.util.function.Function;

public class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + "Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("c\\+\\+", "**Censored**");
    }

    public static void main(String[] args) {
        final Function<String, String> addHeader = Letter::addHeader;
        final Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
        System.out.println(transformationPipeline.apply("C++ stay away from me!"));
    }
}
