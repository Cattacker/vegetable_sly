<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta charset="utf-8">
        <script type="text/javascript">
    		var filebrowserUploadUrl = ‘传送地址‘;
		</script>
        <title>编写旅游日志</title>
        <!-- Make sure the path to CKEditor is correct. -->
        <script src="ckeditor/ckeditor.js"></script>
    </head>
    <body>
        <form action="editor.action">
            <textarea name="editor1" id="editor1" rows="10" cols="80">
                请在这里开始编辑
            </textarea>
            <script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace( 'editor1' );
            </script>
            <input type="submit" value="提交"/>
        </form>
        <script type="text/javascript">
			function ckeditorUpload(file){
   				$('#cke_124_textInput').val(file);
   				$('#cke_205_label').click();
			}
		</script>
    </body>
</html>