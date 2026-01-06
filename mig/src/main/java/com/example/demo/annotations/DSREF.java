package com.example.demo.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DSREF {
	public String den() default "";

	public String uid() default "";

	public String cls() ;

	//public String chn() default "";

	//public String enDef() default "";

	//public String cardinality() default "";;

	//public String boro() default "";

	//public String sam() default ""; // sample

	//public String re() default ""; // remark
}
