package com.mycompany.camel.spring;

import com.altova.io.Input;
import com.altova.io.Output;
import com.mapforce.MappingMapToVaccinationQueryReport;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class VaccinationReportTransformer{
	String output = "/tmp/MyCustomReport";

	public String transform(final InputStream input) {

		final ByteArrayOutputStream out = new ByteArrayOutputStream();

		System.out.println("Called VaccinationReportTransformer.transform(Message msg)");

		MappingMapToVaccinationQueryReport mapping2XML = new MappingMapToVaccinationQueryReport();
		try {
			mapping2XML.run(new Input(Input.IO_STREAM) {
				@Override
				public InputStream getStream() {
					return input;
				}
			}, new Output(Output.IO_STREAM) {
				@Override
				public OutputStream getStream() throws Exception {
					return out;
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("could not run mapping", e);
		}

		return new String(out.toByteArray());
	}
}


