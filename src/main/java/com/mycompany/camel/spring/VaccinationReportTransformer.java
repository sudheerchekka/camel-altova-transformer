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
					//return super.getStream();
					return out;
				}
			});
			
			//mapping2XML.run("/tmp/hl7multi_v02_v04.hl7", "/tmp/MyCustomReport/hl7multi_v02_v04.out.hl7");
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("could not run mapping", e);
		}

		return new String(out.toByteArray());
	}

//	String elementName = "return";
//	public String transform(Element from){	
//		MappingMapToVaccinationQueryReport mapping2XML = new MappingMapToVaccinationQueryReport();
//		String output = "MyCustomReport";
//        String input = null;
//
//		NodeList nodes =	from.getElementsByTagName(elementName);
//		if(nodes.getLength()>0){
//			input = nodes.item(0).getChildNodes().item(0).getNodeValue();
//			try {
//				mapping2XML.run(input, output);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	
//
//
//			return output;
//
//	}
}


