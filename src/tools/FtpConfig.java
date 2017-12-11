package tools;

public class FtpConfig {

	  // 主机ip
	  private String FtpHost;
	  // 端口号
	  private Integer FtpPort=443;
	  // ftp用户名
	  private String FtpUser;
	  // ftp密码
	  private String FtpPassword;
	  // ftp中的目录
	  private String FtpPath;

	  public String getFtpHost() {
	    return FtpHost;

	  }

	  public Integer getFtpPort() {
	    return FtpPort;
	  }

	  public void setFtpPort(Integer ftpPort) {
	    FtpPort = ftpPort;
	  }

	  public void setFtpHost(String ftpHost) {
	    FtpHost = ftpHost;
	  }

	  public String getFtpUser() {
	    return FtpUser;
	  }

	  public void setFtpUser(String ftpUser) {
	    FtpUser = ftpUser;
	  }

	  public String getFtpPassword() {
	    return FtpPassword;
	  }

	  public void setFtpPassword(String ftpPassword) {
	    FtpPassword = ftpPassword;
	  }

	  public String getFtpPath() {
	    return FtpPath;
	  }

	  public void setFtpPath(String ftpPath) {
	    FtpPath = ftpPath;
	  }

	}