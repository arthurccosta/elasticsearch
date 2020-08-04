package br.com.study.elasticsearch;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JSONSchemaTest {

    @Test
    public void invalidJson() throws ValidationException, IOException, JSONException {

        //carrega schema validation
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(
                        new String(JSONSchemaTest.class.getResourceAsStream("/schema-validation.json").readAllBytes(),
                                StandardCharsets.UTF_8)));

        //carrega json para validacao
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(
                        new String(JSONSchemaTest.class.getResourceAsStream("/produt-invalid.json").readAllBytes(),
                                StandardCharsets.UTF_8)));


        Schema schema = SchemaLoader.load(jsonSchema);
        assertThrows(ValidationException.class, () -> schema.validate(jsonSubject));
    }

    @Test
    public void validJson() throws ValidationException, IOException, JSONException {

        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(
                        new String(JSONSchemaTest.class.getResourceAsStream("/schema-validation.json").readAllBytes(),
                                StandardCharsets.UTF_8)));

        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(
                        new String(JSONSchemaTest.class.getResourceAsStream("/product-valid.json").readAllBytes(),
                                StandardCharsets.UTF_8)));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
    }
}
