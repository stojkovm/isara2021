package rs.ac.uns.ftn.isa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.protobuf.InvalidProtocolBufferException;

import rs.ac.uns.ftn.isa.messages.OceneProtos.Studenti;

@SpringBootApplication
public class SerijalizacijaJava2Application {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SpringApplication.run(SerijalizacijaJava2Application.class, args);
		
		RestTemplate rTemplate = new RestTemplate();
		String resourceUrl = "http://localhost:8080/api/studenti";
		ResponseEntity<byte[]> resp = rTemplate.exchange(resourceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<byte[]>(){});
		
		//----Java Serialization START----
//		ByteArrayInputStream in = new ByteArrayInputStream(resp.getBody());
//		ObjectInputStream is;
//		List<Student> st = new ArrayList<Student>();
//		try {
//			is = new ObjectInputStream(in);
//			st = (List<Student>) is.readObject();
//			System.out.println(st);
//		} catch (ClassNotFoundException | IOException e) {
//			e.printStackTrace();
//		}
		//---Java Serialization END---
		//----Protobuf START----
		try {
			Studenti stBuf = Studenti.parseFrom(resp.getBody());
			System.out.println(stBuf);
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		//----Protobuf END----
	}

}
