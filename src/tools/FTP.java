package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTP { 

private static FTPClient ftp;


/**
 * 获取ftp连接
 * @param f
 * @return
 * @throws Exception
 */
public static boolean connectFtp(FtpConfig f) throws Exception{
    ftp=new FTPClient();
    boolean flag=false;
    if (f.getFtpPort()==null) {
        ftp.connect(f.getFtpHost(),21);
    }else{
        ftp.connect(f.getFtpHost(),f.getFtpPort());
    }
    ftp.login(f.getFtpUser(), f.getFtpPassword());
    int reply = ftp.getReplyCode();      
    if (!FTPReply.isPositiveCompletion(reply)) {      
          ftp.disconnect();      
          return flag;      
    }      
    ftp.changeWorkingDirectory(f.getFtpPath());      
    flag = true;      
    return flag;
}

/**
 * 关闭ftp连接
 */
public static void closeFtp(){
  try {
      if (ftp!=null && ftp.isConnected()) {
            ftp.logout();
            ftp.disconnect();
      }
  }catch (IOException e){
    e.printStackTrace();
  }   
}

/**
 * ftp上传文件
 * @param f
 * @throws Exception
 */
public static void upload(File f) throws Exception{
    if (f.isDirectory()) {
        ftp.makeDirectory(f.getName());
        ftp.changeWorkingDirectory(f.getName());
        String[] files=f.list();
        for(String fstr : files){
            File file1=new File(f.getPath()+File.separator+fstr);
            if (file1.isDirectory()) {
                upload(file1);
                ftp.changeToParentDirectory();
            }else{
                File file2=new File(f.getPath()+File.separator+fstr);
                FileInputStream input=new FileInputStream(file2);
                ftp.storeFile(file2.getName(),input);
                input.close();
            }
        }
    }else{
        File file2=new File(f.getPath());
        FileInputStream input=new FileInputStream(file2);
        ftp.storeFile(file2.getName(),input);
        input.close();
    }
}

/**
 * 下载链接配置
 * @param f
 * @param localBaseDir 本地目录
 * @param remoteBaseDir 远程目录
 * @throws Exception
 */
public static void startDownDir(FtpConfig f,String localBaseDir,String remoteBaseDir) throws Exception{
    if (FTP.connectFtp(f)) {
        try { 
            FTPFile[] files = null; 
            boolean changedir = ftp.changeWorkingDirectory(remoteBaseDir); 
            if (changedir) { 
                ftp.setControlEncoding("UTF-8"); 
                files = ftp.listFiles(); 
                for (int i = 0; i < files.length; i++) { 
                     downloadFile(files[i], localBaseDir, remoteBaseDir); 
                } 
            }else{
                 System.out.println("不存在的相对路径！");
            } 
        } catch (Exception e) { 
          e.printStackTrace();
        } 
    }else{
       System.out.println("连接失败");
    }

}

public static void startDownFile(FtpConfig f,String localBaseDir,String remoteFilePath) throws Exception{
  if (FTP.connectFtp(f)) {
    try { 
      FileOutputStream outputStream = new FileOutputStream(localBaseDir + remoteFilePath); 
      ftp.retrieveFile(remoteFilePath, outputStream);
      outputStream.flush();
      outputStream.close();
    } catch (Exception e) { 
      e.printStackTrace();
    } 
  }else{
    System.out.println("连接FTP服务器失败");
  }

}


public static void main(String[] args) throws Exception{  
        FtpConfig f=new FtpConfig();
        f.setFtpHost("192.168.3.100");
        f.setFtpPort(21);
        f.setFtpUser("anonymous");
        f.setFtpPassword("");
        // f.setFtpPath("/data1/");//相对路径
        FTP.connectFtp(f);
        File file = new File("E:\\data1\\physics.txt");

        //FtpUtil.upload(file);//把文件上传在ftp上
        // FtpUtil.startDownFile(f, "E:/",  "physics.txt");
        FTP.startDownDir(f, "E:/data1/",  "/data1/");

   }  
}