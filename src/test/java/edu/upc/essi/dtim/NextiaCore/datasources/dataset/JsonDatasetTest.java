package edu.upc.essi.dtim.NextiaCore.datasources.dataset;

import edu.upc.essi.dtim.NextiaCore.graph.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonDatasetTest {

    private final String TEST_FILE = "..\\NextiaCore\\src\\test\\java\\resources\\jsonTestFile.json";
    private final String TEST_ID = "test_id";
    private final String TEST_NAME = "test_name";
    private final String TEST_DESC = "test_desc";



    @Test
    public void testConstructor() {
        JsonDataset dataset = new JsonDataset(TEST_ID, TEST_NAME, TEST_DESC, TEST_FILE);

        assertEquals(TEST_ID, dataset.getDatasetId());
        assertEquals(TEST_NAME, dataset.getName());
        assertEquals(TEST_DESC, dataset.getDescription());
        assertEquals(TEST_FILE, dataset.getPath());
    }

    @Test
    public void testConstructorExceptionCsvFile() {
        String WRONG_FORMAT_FILE_JSON = "..\\NextiaCore\\src\\test\\java\\resources\\csvTestFile.csv".replace("\\", "/");
        // Act
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new JsonDataset(TEST_ID, TEST_NAME, TEST_DESC, WRONG_FORMAT_FILE_JSON));

        // Assert
        String expectedMessage = "Invalid file format. Only JSON files are supported.";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testConstructorExceptionTxtFile() {
        String WRONG_FORMAT_FILE_TXT = "..\\NextiaCore\\src\\test\\java\\resources\\test.txt".replace("\\", "/").replace("\\", "/");
        // Act
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new JsonDataset(TEST_ID, TEST_NAME, TEST_DESC, WRONG_FORMAT_FILE_TXT));

        // Assert
        String expectedMessage = "Invalid file format. Only JSON files are supported.";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetDatasetType() {
        Dataset dataset = new JsonDataset(TEST_ID, TEST_NAME, TEST_DESC, TEST_FILE);

        assertEquals("json", dataset.getDatasetType());
    }
}