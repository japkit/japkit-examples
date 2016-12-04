package de.japkit.examples.simpledto;

import de.japkit.annotations.RuntimeMetadata;
import de.japkit.metaannotations.Clazz;
import de.japkit.metaannotations.Field;
import de.japkit.metaannotations.Getter;
import de.japkit.metaannotations.Setter;
import de.japkit.metaannotations.classselectors.SrcType;

@Clazz(nameSuffixToAppend = "DTO")
@RuntimeMetadata
public class DTOTemplate implements SrcInterface {
	@Field(src = "#{src.properties}",
			getter = @Getter,
			setter = @Setter)
	private SrcType $name$;
}
