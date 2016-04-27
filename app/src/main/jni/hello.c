#include <jni.h>
#include <unistd.h>
//#include <iostream>
#include <string.h>
//#include <libjson.h>
#include<stdio.h>	//printf
#include<string.h>	//strlen
#include<sys/socket.h>	//socket
#include<arpa/inet.h>	//inet_addr
JNIEXPORT jstring JNICALL
Java_com_example_ekkert_myapplication_Main2Activity_stringFromJNI(JNIEnv *env, jobject instance) {
    int sock;
    struct sockaddr_in server;
    char message[1000];
    //char *server_reply =(char *) malloc(1*sizeof(char));
    char *server_reply =(char *) malloc(50*sizeof(char));

    //Create socket
    sock = socket(AF_INET , SOCK_STREAM , 0);
    if (sock == -1)
    {
        return (*env)->NewStringUTF(env, "Could not create socket");
    }

    //puts("Socket created");

    server.sin_addr.s_addr = inet_addr("192.168.2.52");
    server.sin_family = AF_INET;
    server.sin_port = htons( 5000 );

    //Connect to remote server
    if (connect(sock , (struct sockaddr *)&server , sizeof(server)) < 0)
    {
        return (*env)->NewStringUTF(env, "Connection to server failed");

    }


    //keep communicating with server
    /*while(1)
    {*/
    /*printf("Enter message : ");
    scanf("%s" , message);

    //Send some data
    if( send(sock , message , strlen(message) , 0) < 0)
    {
        puts("Send failed");
        return 1;
    }*/
    int n = read(sock , server_reply , 50);
    //Receive a reply from the server
    if( n < 0)
    {
        return (*env)->NewStringUTF(env, "receive failed");
    }
    char *b = "5";
    //puts("Server reply :");
    return (*env)->NewStringUTF(env, server_reply);
    //}

    close(sock);
    return 0;

    //return (*env)->NewStringUTF(env, "dsds");
}