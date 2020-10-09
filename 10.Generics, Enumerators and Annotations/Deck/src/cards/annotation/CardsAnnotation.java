package cards.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CardsAnnotation {
	String type();

	String category() default "CardGame";

	String description();


}
