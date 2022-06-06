//package com.example.myfirstproject.utils
//
//import android.content.Context
//import android.graphics.Region
//import com.amazonaws.auth.AWSCredentials
//import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver
//import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility
//import com.amazonaws.regions.Region
//import com.amazonaws.regions.Regions
//import com.amazonaws.services.s3.AmazonS3Client
//import com.amazonaws.services.s3.model.CannedAccessControlList
//import java.io.File
//
//object S3Uploader {
//
//    fun upload(context: Context, credentialsProvider: AWSCredentials, bucketName:String, filepath:String, uploadfileName:String): TransferObserver {
//        val s3 = AmazonS3Client(credentialsProvider, Region.getRegion(Regions.US_EAST_1))
//
//        val transferUtility = TransferUtility.builder().s3Client(s3).context(context).build()
//        return transferUtility.upload(
//            bucketName,   //this is the bucket name on S3
//            uploadfileName,  //this is the path and name
//            File(filepath),  //path to the file locally
//            CannedAccessControlList.PublicRead //to make the file public
//        )
//
//    }
//    fun upload(context: Context,credentialsProvider: AWSCredentials,bucketName:String,file:File,uploadfileName:String):TransferObserver {
//        val s3 = AmazonS3Client(credentialsProvider,com.amazonaws.regions.Region.getRegion(Regions.US_EAST_1))
//
//        val transferUtility = TransferUtility.builder().s3Client(s3).context(context).build()
//        return transferUtility.upload(
//            bucketName,   //this is the bucket name on S3
//            uploadfileName,  //this is the path and name
//            file,  //path to the file locally
//            CannedAccessControlList.PublicRead //to make the file public
//        )
//
//    }
//
//}