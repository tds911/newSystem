package com.tds.modules.service;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

public interface FileService {

    public void toZip(List<File> srcFiles, OutputStream out);
}
