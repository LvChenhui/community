package com.wl.lch.service;

import com.wl.lch.dto.EstherDTO;
import com.wl.lch.entity.Label;

import java.util.List;

public interface LabelService {

    public List<Label> findLabels();

    public List<EstherDTO> findPostByLabel(int labelId, int pageNo, int length);

    public int sumPageSizeByLabel(int labelId);
}
