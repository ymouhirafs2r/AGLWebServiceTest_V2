package wsClient;

/**
 * Copyright(c) AFS2R Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of AFS2R Company.
 * User: ymouhir
 * Date: 02/01/14
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

import aglsiws.AGLSIWS;
import aglsiws.AGLSIWSService;
import aglsiws.Camera;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class MainClient {

    public static void main(String[] args) throws MalformedURLException {
        AGLSIWS  service = new AGLSIWSService().getAGLSIWSPort();

        BindingProvider bp = (BindingProvider)service;

        System.out.println("Configure address...");

        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:9000/AGLSIWS/AGLSIWS");
        bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, Collections.singletonMap("Accept-Encoding", Collections.singletonList("gzip")));
        bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "STCL");
        bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "K&3w*z412");


        /******************************************************************************************************************/
        /*
             getALLLocalSiteGroup Test
         */
        //WSTest.getAllLocalSitesGroup(service);
        /******************************************************************************************************************/


        /******************************************************************************************************************/
        /*
             getALLLocalSite Test
         */
        //WSTest.getAllLocalSites(service);
        /******************************************************************************************************************/


        /******************************************************************************************************************/
        /*
             getALLSensor Test
         */
        //WSTest.getAllSensors(service);
        /******************************************************************************************************************/


        /******************************************************************************************************************/
        /*
             getVersion Test
         */
        //WSTest.getVersion(service);
        /******************************************************************************************************************/


        /******************************************************************************************************************/
        /*
             getAnprImage Test
         */
        WSTest.getAnprImage(service, 29420);
        /******************************************************************************************************************/

        /******************************************************************************************************************/
        /*
             getContextImage Test
         */
        //WSTest.getContextImage(service, 25098);
        /******************************************************************************************************************/


        /******************************************************************************************************************/
        /*
             getLogsSinceLastId Test
         */
        //WSTest.getLogsSinceLastId(service, 0, 10);
        /******************************************************************************************************************/


    }
}
