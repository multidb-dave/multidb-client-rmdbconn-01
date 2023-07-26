package com.xql.clientmdb;

public class App {
    public static void main(String[] args) {
        String baseUrl = "http://localhost:8080";
        // String baseUrl = "http://api001.multidb.net:8080";

        // List of virtual schemas
        String url = baseUrl + "/api/v1/schemas";
        ListSchemas listSchemas = new ListSchemas();
        listSchemas.setUrl(url);
        listSchemas.getSchemas();
        System.out.println();

        // List of database sources
        url = baseUrl + "/api/v1/dbconns";
        ListDbconns listDbconns = new ListDbconns();
        listDbconns.setUrl(url);
        listDbconns.getDbconns();
        System.out.println();

        // Cannot remove dbconn which is still being used by schemas
        // Remove schemas first before removing dbconns
        RemoveDbconn removeDbconn = new RemoveDbconn();
        removeDbconn.setBaseUrl(baseUrl);

        // incorrect input
        // 1. remove a database source: null
        System.out.println("1. remove a dataabase source: null");
        url = baseUrl + "/api/v1/rmdbconn";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn(null);

        removeDbconn.removeDbconn();
        System.out.println();

        // incorrect input
        // 2. remove a database source: null
        System.out.println("2. remove a dataabase source: /null");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn(null);

        removeDbconn.removeDbconn();
        System.out.println();

        // incorrect input
        // 3. remove a database source: empty string
        System.out.println("3. remove a dataabase source: empty string");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("");

        removeDbconn.removeDbconn();
        System.out.println();

        // incorrect input
        // 4. remove a database source: blank string
        System.out.println("4. remove a dataabase source: blank string");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("     ");

        removeDbconn.removeDbconn();
        System.out.println();

        // incorrect input
        // 5. remove a database source: special character space
        System.out.println("5. remove a dataabase source: special character space");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("psql_ northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        // incorrect input
        // 6. remove a database source: special character #
        System.out.println("6. remove a dataabase source: special character #");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("psql_north#wind");

        removeDbconn.removeDbconn();
        System.out.println();

        // Cannot remove dbconn which is still being used by schemas
        // Remove schemas first before removing dbconns

        // correct input
        // 7. remove a database source: psql_northwind
        System.out.println("7. remove a dataabase source: psql_northwind");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("psql_northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        url = baseUrl + "/api/v1/schemas";
        listSchemas.setUrl(url);
        listSchemas.getSchemas();
        System.out.println();

        url = baseUrl + "/api/v1/dbconns";
        listDbconns.setUrl(url);
        listDbconns.getDbconns();
        System.out.println();

    }
}
