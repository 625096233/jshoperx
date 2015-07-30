package com.jshoperx.action.backstage.image;

import com.jshoperx.action.backstage.base.BaseTAction;
import com.jshoperx.action.backstage.image.bean.ServerFileInfoBean;
import com.jshoperx.action.backstage.image.qiniu.ImgFileBean;
import com.jshoperx.action.backstage.image.qiniu.QiNiuConfig;
import com.jshoperx.action.backstage.image.qiniu.QiNiuUploadFiles;
import com.jshoperx.action.backstage.utils.BaseTools;
import com.jshoperx.action.backstage.utils.GsonJson;
import com.jshoperx.action.backstage.utils.ImgCutTools;
import com.jshoperx.action.backstage.utils.Validate;
import com.jshoperx.action.backstage.utils.config.GlobalParam;
import com.jshoperx.action.backstage.utils.config.ReadSysConfig;
import com.jshoperx.action.backstage.utils.statickey.StaticKey;
import com.qiniu.api.auth.AuthException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Namespace("")
@ParentPackage("jshoperx")
public class ImgTAction extends BaseTAction implements ServletResponseAware,
		ServletRequestAware {
	private static final Logger log = LoggerFactory.getLogger(ImgTAction.class);

	private static final long serialVersionUID = 1L;
	private final static String DIR = "Uploads";
	private final static String SVNDIR = ".svn";
	private File fileupload;
	private String fileuploadFileName;
	private String allfilename;
	private String qqfile;
	private String directoryname;
	private String filestrs;
	private HttpServletResponse response;
	private HttpServletRequest request;
	/**
	 * 保存服务器文件目录
	 */
	private List<ServerFileInfoBean> list = new ArrayList<ServerFileInfoBean>();
	private String query;
	private String qtype;
	private int total = 0;
	private int rp;
	private int page = 1;
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private String creatorid;
	private String imgdirpath;
	/**
	 * 上传图片后保存的路径
	 */
	private String mNewImgPath;
	/**
	 * 图片文件保存的目录
	 */
	private String targetSavePath;
	/**
	 * 云存储文件名
	 */
	private String cloudFileKey;
	private String extName;// 文件后缀

	private boolean sucflag;

	public String getCloudFileKey() {
		return cloudFileKey;
	}

	public void setCloudFileKey(String cloudFileKey) {
		this.cloudFileKey = cloudFileKey;
	}

	public String getExtName() {
		return extName;
	}

	public void setExtName(String extName) {
		this.extName = extName;
	}

	public String getTargetSavePath() {
		return targetSavePath;
	}

	public void setTargetSavePath(String targetSavePath) {
		this.targetSavePath = targetSavePath;
	}

	public String getmNewImgPath() {
		return mNewImgPath;
	}

	public void setmNewImgPath(String mNewImgPath) {
		this.mNewImgPath = mNewImgPath;
	}

	public File getFileupload() {
		return fileupload;
	}

	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}

	public String getFileuploadFileName() {
		return fileuploadFileName;
	}

	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}

	public String getAllfilename() {
		return allfilename;
	}

	public void setAllfilename(String allfilename) {
		this.allfilename = allfilename;
	}

	@JSON(serialize = false)
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@JSON(serialize = false)
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getQqfile() {
		return qqfile;
	}

	public void setQqfile(String qqfile) {
		this.qqfile = qqfile;
	}



	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getImgdirpath() {
		return imgdirpath;
	}

	public void setImgdirpath(String imgdirpath) {
		this.imgdirpath = imgdirpath;
	}

	public String getDirectoryname() {
		return directoryname;
	}

	public void setDirectoryname(String directoryname) {
		this.directoryname = directoryname;
	}

	public String getFilestrs() {
		return filestrs;
	}

	public void setFilestrs(String filestrs) {
		this.filestrs = filestrs;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 读取服务器文件夹下得文件
	 */
	@Action(value = "readAllSeverDirectoryFile", results = { @Result(name = "json", type = "json") })
	public String readAllSeverDirectoryFile() {
		this.findDefaultDirectoryFile();
		return "json";

	}

	/**
	 * 获取服务器文件夹下文件
	 * 
	 * @return
	 */
	public void findDefaultDirectoryFile() {
		int currentPage = page;
		int lineSize = rp;
		if (Validate.StrNotNull(this.getDirectoryname())) {
			String savedir = "/" + DIR + File.separatorChar;
			String savePath = ServletActionContext.getServletContext()
					.getRealPath("");
			savePath = savePath + savedir + this.getDirectoryname()
					+ File.separatorChar;
			File file = new File(savePath);
			String[] filelist = file.list();
			SimpleDateFormat sDateFormat;
			sDateFormat = new SimpleDateFormat("yyyyMMddmmss");
			String nowTimeStr = "";
			if (list != null) {
				list.clear();
			}
			for (int i = 0; i < filelist.length; i++) {
				File f = new File(file.getPath(), filelist[i]);
				if (f.isFile() && !f.isHidden()) {
					nowTimeStr = sDateFormat.format(new Date(f.lastModified()));
					ServerFileInfoBean sfi = new ServerFileInfoBean();
					sfi.setDirectoryname(f.getName());
					sfi.setCreatetime(nowTimeStr);
					sfi.setImgfilepath(savedir + this.getDirectoryname() + "/"
							+ f.getName());
					list.add(sfi);
				}
			}
			if (list != null && list.size() > 0) {
				total = currentPage * lineSize > list.size() ? list.size()
						: currentPage * lineSize;
				list.subList((currentPage - 1) * lineSize, total);
				this.ProcessAllSeverDirectoryFile(list);
			}
		}
	}

	public void ProcessAllSeverDirectoryFile(List<ServerFileInfoBean> list) {
		rows.clear();
		for (Iterator<ServerFileInfoBean> it = list.iterator(); it.hasNext();) {
			ServerFileInfoBean sfi = it.next();
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", sfi.getDirectoryname());
			cellMap.put(
					"cell",
					new Object[] {
							"<img width='100px' height='100px' src='"
									+ BaseTools.getBasePath()
									+ sfi.getImgfilepath()
									+ "'/><br/><a target='_blank' href='"
									+ BaseTools.getBasePath()
									+ sfi.getImgfilepath() + "'>"
									+ sfi.getDirectoryname() + "</a>",
							sfi.getCreatetime() });
			rows.add(cellMap);
		}
	}

	/**
	 * 创建服务器目录
	 * 
	 * @return
	 */
	@Action(value = "createDirectory", results = { @Result(name = "json", type = "json") })
	public String createDirectory() {
		String savedir = "/" + DIR + File.separatorChar;
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"");
		savePath = savePath + savedir + this.getImgdirpath()
				+ File.separatorChar;
		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}
	}

	/**
	 * 检测目录是否存在
	 * 
	 * @return
	 */

	public String isexistdir() {
		String nowTimeStr = "";
		String savedir = DIR + "/";
		String realpath = "";
		SimpleDateFormat sDateFormat;
		sDateFormat = new SimpleDateFormat("yyyyMMdd");
		nowTimeStr = sDateFormat.format(new Date());
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		savePath = savePath + savedir + nowTimeStr + "/";
		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
			realpath = savedir + nowTimeStr + "/";
			return realpath;
		} else {
			realpath = savedir + nowTimeStr + "/";
			return realpath;
		}
	}

	/**
	 * 异步图片
	 * 
	 * @throws JSONException
	 * @throws AuthException
	 * 
	 * @throws IOException
	 */
	@Action(value = "ajaxFileUploads", results = { @Result(name = "json", type = "json") })
	public String ajaxFileUploads() throws JSONException, AuthException {
		String extName=StaticKey.EMPTY;
		String newFileFullname = StaticKey.EMPTY;//包含后缀的文件名
		String newFileName=StaticKey.EMPTY;//没有包含后缀的文件名
		String nowTimeStr = StaticKey.EMPTY;
		String realpath = StaticKey.EMPTY;
		if (Validate.StrNotNull(this.getImgdirpath())) {
			realpath = DIR + "/" + this.getImgdirpath() + "/";
		} else {
			realpath = this.isexistdir();
		}
		SimpleDateFormat sDateFormat;
		Random r = new Random();
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		savePath = savePath + realpath;
		HttpServletResponse response = ServletActionContext.getResponse();
		int rannum = (int) (r.nextDouble() * (99999 - 1000 + 1)) + 10000;
		sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		nowTimeStr = sDateFormat.format(new Date());
		String filename = request.getHeader(StaticKey.X_FILE_NAME);
		if (filename.lastIndexOf(StaticKey.DOT) >= 0) {
			extName = filename.substring(filename.lastIndexOf(StaticKey.DOT));
		}
		//包含后缀的文件全名
		newFileFullname = nowTimeStr + rannum + extName;
		//不包含后缀的文件全名
		newFileName=nowTimeStr+rannum;
		PrintWriter writer = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			writer = response.getWriter();
			is = request.getInputStream();
			fos = new FileOutputStream(new File(savePath + newFileFullname));
			IOUtils.copy(is, fos);
			
			ImgFileBean ifb=new ImgFileBean();
			String localFile = savePath + newFileFullname;// 已上传到本地的图片路径
			String cloudFileKey = realpath + newFileFullname;// 云上的文件名称
			String compressLocalFile=StaticKey.EMPTY;//已上传到本地的压缩图片路径
			String compresscloudFileKey=StaticKey.EMPTY;//云上的压缩文件名称
			Properties p = ReadSysConfig.getJConfig();
			// 检测是否启用云存储图片
			String issaveimgtocloud = p.getProperty(
					GlobalParam.ISSAVEIMGTOCLOUD, StaticKey.ZERO);
			if (StringUtils.equals(issaveimgtocloud, StaticKey.ONE)) {
				int code = QiNiuUploadFiles.upLoads(localFile, cloudFileKey);
				if (200 == code) {
					response.setStatus(HttpServletResponse.SC_OK);
					//writeFileInfo="{success:'" + QiNiuConfig.QINIUIMGHOST+ cloudFileKey + "'}";
					ifb.setSucflag(true);
					ifb.setCloudImg(true);
					ifb.setNormalfilepath(QiNiuConfig.QINIUIMGHOST+ cloudFileKey);
				}
			}else if(StringUtils.equals(issaveimgtocloud, StaticKey.ZERO)){
				//如果不启用云存储表示本地存储
				ifb.setSucflag(true);
				ifb.setNormalfilepath(cloudFileKey);
			}
			boolean isImg=ImgCutTools.checkIsImg(extName);
			if(isImg){
				//检测是否需要压缩图片
				String isimagecompression = p.getProperty(
						GlobalParam.ISIMAGECOMPRESSION, StaticKey.ZERO);
				if (isimagecompression.equals(StaticKey.ONE)) {
					// 只有当开启压缩时才执行压缩方法并保存缩略图
					int width = Integer.parseInt(p.getProperty(
							GlobalParam.THUMBNAILWIDTH,
							GlobalParam.DEFAULTWIDTH));
					int height = Integer.parseInt(p.getProperty(
							GlobalParam.THUMBNAILHEIGHT,
							GlobalParam.DEFAULTHEIGHT));
					compressLocalFile=ImgCutTools.compressImages(localFile, savePath,
							width, height);
					compresscloudFileKey=newFileName+ "_" + String.valueOf(width) + "_"
							+ String.valueOf(height) + extName;
					if(compressLocalFile!=null){
						if (StringUtils.equals(issaveimgtocloud, StaticKey.ONE)) {
							//调用七牛云存储，存储压缩后的图片
							int code = QiNiuUploadFiles.upLoads(compressLocalFile, compresscloudFileKey);
							if (200 == code) {
								ifb.setSucflag(true);
								ifb.setCloudImg(true);
								ifb.setCompressfilepath(QiNiuConfig.QINIUIMGHOST+ compresscloudFileKey);
							}
						}else if(StringUtils.equals(issaveimgtocloud, StaticKey.ZERO)){
							ifb.setSucflag(true);
							ifb.setCompressfilepath(realpath+compresscloudFileKey);
						}
					}
				}
				// 检测是否本地保存原图，如果不保存原图意味着删除本地图片
				String issaveoriginalbitmap = p.getProperty(
						GlobalParam.ISSAVEORIGINALBITMAP, StaticKey.ZERO);
				if (StringUtils.equals(issaveoriginalbitmap, StaticKey.ZERO)) {
					//删除本地原图
					File file = new File(localFile);
					if (file != null) {
						if (file.exists() && file.isFile() && !file.isHidden()) {
							file.delete();
						}
					}
					//删除本地压缩图
					File compressFile=new File(compressLocalFile);
					if (compressFile != null) {
						if (compressFile.exists() && compressFile.isFile() && !compressFile.isHidden()) {
							compressFile.delete();
						}
					}
				}
			}
			writer.print(GsonJson.parseDataToJson(ifb));
		} catch (FileNotFoundException ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
			log.debug(ImgTAction.class.getName() + "has thrown an exception: "
					+ ex.getMessage());
		} catch (IOException ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
			log.debug(ImgTAction.class.getName() + "has thrown an exception: "
					+ ex.getMessage());
		} finally {
			try {
				this.setImgdirpath(null);
				if (fos != null) {
					fos.close();
				}
				if (is != null) {
					is.close();
				}
				if(writer!=null){
					writer.flush();
					writer.close();
				}
			} catch (IOException e) {
				log.debug(ImgTAction.class.getName() + "has thrown an exception:"
						+ e.getMessage());
			}
		}
		return JSON;
	}

	/**
	 * 读取服务器文件
	 */
	@Action(value = "readAllSeverDirectory", results = { @Result(name = "json", type = "json") })
	public String readAllSeverDirectory() {
		if (StaticKey.SC.equals(this.getQtype())) {
			this.findDefaultAllSeverDirectory();
			return "json";
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
	}

	public void findDefaultAllSeverDirectory() {
		int currentPage = page;
		int lineSize = rp;
		String savedir = "/" + DIR + "/";
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		savePath = savePath + savedir;
		File file = new File(savePath);
		String[] filelist = file.list();
		SimpleDateFormat sDateFormat;
		sDateFormat = new SimpleDateFormat("yyyyMMddmmss");
		String nowTimeStr = StaticKey.EMPTY;
		List<ServerFileInfoBean> list=new ArrayList<ServerFileInfoBean>();
		if(filelist!=null){
			for (int i = 0; i < filelist.length; i++) {
				File f = new File(file.getPath(), filelist[i]);
				if (f.isDirectory() && !f.getName().equals(SVNDIR) && !f.isHidden()) {
					String filecount[] = f.list();
					nowTimeStr = sDateFormat.format(new Date(f.lastModified()));
					ServerFileInfoBean sfi = new ServerFileInfoBean();
					sfi.setDirectoryname(f.getName());
					sfi.setCreatetime(nowTimeStr);
					sfi.setCount(filecount.length);
					list.add(sfi);
				}
			}
		}
		if (list != null && list.size() > 0) {
			total = currentPage * lineSize > list.size() ? list.size()
					: currentPage * lineSize;
			list.subList((currentPage - 1) * lineSize, total);
			this.ProcessAllSeverDirectory(list);
		}
	}

	public void ProcessAllSeverDirectory(List<ServerFileInfoBean> list) {
		rows.clear();
		for (Iterator<ServerFileInfoBean> it = list.iterator(); it.hasNext();) {
			ServerFileInfoBean sfi =  it.next();
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", sfi.getDirectoryname());
			cellMap.put("cell", new Object[] {
					"<a href='imagematerialfolderlistment.jsp?directoryname="
							+ sfi.getDirectoryname() + "&folder=images" + "'>"
							+ sfi.getDirectoryname() + "</a>", sfi.getCount(),
					sfi.getCreatetime() });
			rows.add(cellMap);
		}
	}

	/**
	 * 删除服务器端文件
	 */
	@Action(value = "delServerDirectoryFile", results = { @Result(name = "json", type = "json") })
	public String delServerDirectoryFile() {
		String savedir = "/"+DIR+"/";
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		if (Validate.StrNotNull(this.getDirectoryname())) {
			String dirs[]=StringUtils.split(this.getDirectoryname(), StaticKey.SPLITDOT);
			for (int i = 0; i < dirs.length; i++) {
				savePath = savePath + savedir + dirs[i] + "/";
				File file = new File(savePath);
				if (file.exists()) {
					String[] filelist = file.list();
					if(filelist!=null){
						for (int j = 0; j < filelist.length; j++) {
							File f = new File(file.getPath(), filelist[j]);
							if (f.exists() && f.isFile() && !f.isHidden()) {
								f.delete();
							}
						}
					}
					file.delete();
				}
			}

			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 删除服务器上单个文件
	 * 
	 * @return
	 */
	@Action(value = "delServerFile", results = { @Result(name = "json", type = "json") })
	public String delServerFile() {
		String savedir = "/" + DIR + "/";
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		if (Validate.StrNotNull(this.getFilestrs())) {
			String dir = this.getDirectoryname().trim();
			String files[] = this.getFilestrs().split(",");
			for (int i = 0; i < files.length; i++) {
				savePath = savePath + savedir + dir + File.separatorChar
						+ files[i];
				File f = new File(savePath);
				if (f.exists() && f.isFile() && !f.isHidden()) {
					f.delete();
				}
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}




}
