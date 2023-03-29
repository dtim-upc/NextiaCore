package edu.upc.essi.dtim.DataSources;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

class DatasetTest {
    @Test
    void testConstructorWithName() {
        Dataset dataset = new Dataset("test");
        assertEquals("test", dataset.getName());
    }

    @Test
    void getDatasetId() {
        Dataset dataset = new Dataset("test");
        dataset.setDatasetId("123");
        assertEquals("123", dataset.getDatasetId());
    }

    @Test
    void getName() {
        Dataset dataset = new Dataset("test");
        assertEquals("test", dataset.getName());
    }

    @Test
    void getDescription() {
        Dataset dataset = new Dataset("test");
        dataset.setDescription("test description");
        assertEquals("test description", dataset.getDescription());
    }

    @Test
    void getCreated_at() {
        Dataset dataset = new Dataset("test");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        dataset.setCreated_at(timestamp);
        assertNotNull(dataset.getCreated_at());
    }

    @Test
    void setDatasetId() {
        Dataset dataset = new Dataset("test");
        dataset.setDatasetId("456");
        assertEquals("456", dataset.getDatasetId());
    }

    @Test
    void setName() {
        Dataset dataset = new Dataset("test");
        dataset.setName("new name");
        assertEquals("new name", dataset.getName());
    }

    @Test
    void setDescription() {
        Dataset dataset = new Dataset("test");
        dataset.setDescription("new description");
        assertEquals("new description", dataset.getDescription());
    }

    @Test
    void setCreated_at() {
        Dataset dataset = new Dataset("test");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        dataset.setCreated_at(timestamp);
        assertEquals(timestamp, dataset.getCreated_at());
    }
}