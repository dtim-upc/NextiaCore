package edu.upc.essi.dtim.DataSources.dataset;

import edu.upc.essi.dtim.Graph.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CsvDatasetTest {

    private final String TEST_FILE = "..\\NextiaCore\\src\\test\\java\\resources\\csvTestFile.csv";
    private final String TEST_ID = "test_id";
    private final String TEST_NAME = "test_name";
    private final String TEST_DESC = "test_desc";

    @Test
    public void testConstructor() {
        CsvDataset dataset = new CsvDataset(TEST_ID, TEST_NAME, TEST_DESC, TEST_FILE);

        assertEquals(TEST_ID, dataset.getDatasetId());
        assertEquals(TEST_NAME, dataset.getName());
        assertEquals(TEST_DESC, dataset.getDescription());
        assertEquals(TEST_FILE, dataset.getPath());
    }

    @Test
    public void testConstructorExceptionJsonFile() {
        String WRONG_FORMAT_FILE_JSON = "..\\NextiaCore\\src\\test\\java\\resources\\jsonTestFile.json";
        // Act
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new CsvDataset(TEST_ID, TEST_NAME, TEST_DESC, WRONG_FORMAT_FILE_JSON));

        // Assert
        String expectedMessage = "Invalid file format. Only CSV files are supported.";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testConstructorExceptionTxtFile() {
        String WRONG_FORMAT_FILE_TXT = "..\\NextiaCore\\src\\test\\java\\resources\\test.txt";
        // Act
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new CsvDataset(TEST_ID, TEST_NAME, TEST_DESC, WRONG_FORMAT_FILE_TXT));

        // Assert
        String expectedMessage = "Invalid file format. Only CSV files are supported.";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetDatasetType() {
        CsvDataset dataset = new CsvDataset(TEST_ID, TEST_NAME, TEST_DESC, TEST_FILE);

        assertEquals("csv", dataset.getDatasetType());
    }

    @Test
    public void testConvertToGraph() throws IOException {
        CsvDataset dataset = new CsvDataset(TEST_ID, TEST_NAME, TEST_DESC, TEST_FILE);

        Graph graph = dataset.convertToGraph(TEST_ID, TEST_NAME, TEST_FILE);

        assertNotNull(graph);
        assertEquals(TEST_ID, graph.getName().getURI());
        assertEquals(3, graph.getTriples().size());
    }
}