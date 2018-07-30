package com.vollino.examples.spring.data.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.assertj.core.util.Lists;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.ImmutableMap;
import com.vollino.examples.spring.data.model.Circle;
import com.vollino.examples.spring.data.model.Polygon;
import com.vollino.examples.spring.data.model.PolygonType;
import com.vollino.examples.spring.data.model.Square;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PolygonRepositoryIT {

    @Autowired
    private PolygonRepository polygonRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void setUp() {
        polygonRepository.deleteAll();
    }

    @Test
    public void shouldBootStandaloneService() {
        assertNotNull(polygonRepository);
    }

    @Test
    public void shouldHandleSubtypesWhenUsingTheRepository() {
        List<Polygon> expectedPolygons = Lists.newArrayList(
                new Square("square", PolygonType.SQUARE, 1),
                new Circle("circle", PolygonType.CIRCLE, 2));

        polygonRepository.save(expectedPolygons);
        List<Polygon> actualPolygons = polygonRepository.findAll();

        assertThat(actualPolygons, equalTo(expectedPolygons));
    }

    @Test
    public void shouldHandleSubtypesWhenSavingDocumentUsingMongoTemplateAndFindingWithMongoTemplate() {
        Document square = new Document(ImmutableMap.of(
                "id", "square",
                "type", "SQUARE",
                "size", 1));
        Document circle = new Document(ImmutableMap.of(
                "id", "circle",
                "type", "CIRCLE",
                "radius", 2));

        List<Polygon> expectedPolygons = Lists.newArrayList(
                new Square("square", PolygonType.SQUARE, 1),
                new Circle("circle", PolygonType.CIRCLE, 2));

        mongoTemplate.save(square, "polygon");
        mongoTemplate.save(circle, "polygon");
        List<Polygon> actualPolygons = mongoTemplate.findAll(Polygon.class);

        assertThat(actualPolygons, equalTo(expectedPolygons));
    }

    @Test
    public void shouldHandleSubtypesWhenSavingDocumentUsingMongoTemplateAndFindingWithRepository() {
        Document square = new Document(ImmutableMap.of(
                "id", "square",
                "type", "SQUARE",
                "size", 1));
        Document circle = new Document(ImmutableMap.of(
                "id", "circle",
                "type", "CIRCLE",
                "radius", 2));

        List<Polygon> expectedPolygons = Lists.newArrayList(
                new Square("square", PolygonType.SQUARE, 1),
                new Circle("circle", PolygonType.CIRCLE, 2));

        mongoTemplate.save(square, "polygon");
        mongoTemplate.save(circle, "polygon");
        List<Polygon> actualPolygons = polygonRepository.findAll();

        assertThat(actualPolygons, equalTo(expectedPolygons));
    }

        /*
    public static void main(String args[]) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

        List<Polygon> objects = Lists.newArrayList(
                new Square(PolygonType.SQUARE, 1),
                new Circle(PolygonType.CIRCLE, 2));

        String json = objectMapper.writeValueAsString(objects);
        List<Polygon> processedObjects = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Polygon.class));

        System.out.println(json);
        System.out.println(processedObjects);

        System.out.println("");

        json = objectMapper.writeValueAsString(new Wrapper(objects));
        System.out.println(json);
        Map<String, Object> document = objectMapper.readValue(json, Map.class);
        System.out.println(document);

        System.out.println("");

        json = objectMapper.writeValueAsString(document);
        Wrapper wrapper = objectMapper.readValue(json, Wrapper.class);

        System.out.println(json);
        System.out.println(wrapper);
    }
    */
}