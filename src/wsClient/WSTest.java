package wsClient;

import aglsiws.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;


/**
 * Copyright(c) AFS2R Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of AFS2R Company.
 * User: ymouhir
 * Date: 10/01/14
 */
public class WSTest {

    private static void getImage(AGLSIWS service, long idlog, String type){

        String fileNameJpegTest = "/Users/ymouhir/Dev/test/test3.jpg";
        byte []response=null;
        if(type.equals("anpr")){
            response= service.getAnprImage(idlog);
        }
        if(type.equals("context")){
            response= service.getContextImage(idlog);
        }

        ByteBuffer resultBuffer = ByteBuffer.wrap(response);
        File dataFileDisk = new File(fileNameJpegTest);
        String dirPath = dataFileDisk.getPath();
        File dirDataFileDisk = new File(dirPath).getParentFile();
        dirDataFileDisk.mkdirs();


        byte[] fileContent = new byte[response.length];
        resultBuffer.get(fileContent);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileNameJpegTest);
            fos.write(fileContent);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void getAnprImage(AGLSIWS service, long idlog){
        System.out.println("getAnprImage");
        getImage(service, idlog, "anpr");
    }

    public static void getContextImage(AGLSIWS service, long idlog){
        System.out.println("getContextImage");
        getImage(service, idlog, "context");
    }

    public static void getVersion(AGLSIWS service){
        System.out.println("getVersion");
        System.out.println(service.getVersion());
    }

    public static void getAllSensors(AGLSIWS service){
        System.out.println("getAllSensors");
        for(Camera camera : service.getAllSensors()){
            System.out.println(" Camera : "+camera.getIdSensor() + "-" +camera.getName());
        }
    }

    public static void getAllLocalSites(AGLSIWS service){
        System.out.println("getAllLocalSites");
        for(LocalSite localSite : service.getAllLocalSites()){
            System.out.println(" LocalSite : "+localSite.getIdLocalSite() + "-" +localSite.getName());
        }
    }

    public static void getAllLocalSitesGroup(AGLSIWS service){
        System.out.println("getAllLocalSitesGroup");
        for(LocalSiteGroup localSiteGroup : service.getAllLocalSitesGroup()){
            System.out.println(" localSiteGroup : "+localSiteGroup.getIdLocalSiteGroup() + "-" +localSiteGroup.getName()+" isSite_si : "+localSiteGroup.isSiteSi());
        }
    }

    public static void getLogsSinceLastId(AGLSIWS service, long logId, int limit){
        System.out.println("getLogsSinceLastId");
        for(Log log : service.getLogsSinceLastId(logId, limit)){
            System.out.println(" Log : "+log.getIdLog() + "-" + log.getPlate());
        }
    }




}
