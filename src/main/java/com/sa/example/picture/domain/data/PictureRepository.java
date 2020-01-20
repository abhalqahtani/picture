package com.sa.example.picture.domain.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, String> {

    List<Picture> findAllByProcessed(boolean processed);

    List<Picture> findAllByAccepted(boolean accepted);

    Picture findById(Integer id);
}
