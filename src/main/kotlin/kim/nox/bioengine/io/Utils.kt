package kim.nox.bioengine.io

import com.machinezoo.sourceafis.FingerprintTemplate
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import java.util.Base64

@Throws(IOException::class)
fun extractTemplate(filePath: String): FingerprintTemplate {
    val fileBytes = FileUtils.readFileToByteArray(File(filePath))
    return FingerprintTemplate().dpi(500.0).create(fileBytes)
}

@Throws(IOException::class)
fun encodeFileToBase64(filePath: String): String{
    val bytes = FileUtils.readFileToByteArray(File(filePath))
    return Base64.getEncoder().encodeToString(bytes)
}

@Throws(IOException::class)
fun decodeBase64ToFile(base64Str: String, pathFile: String) {
    val imageByteArray = Base64.getDecoder().decode(base64Str)
    FileUtils.writeByteArrayToFile(File(pathFile), imageByteArray)
}