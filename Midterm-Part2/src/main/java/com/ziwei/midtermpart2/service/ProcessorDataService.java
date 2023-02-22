package com.ziwei.midtermpart2.service;

import com.ziwei.midtermpart2.model.ProcessorsModel;
import com.ziwei.midtermpart2.repository.ProcessorEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ProcessorDataService {
    private static ProcessorDataService processorsRepository;

    ProcessorDataService(ProcessorDataService processorsRepository){
        this.processorsRepository = processorsRepository;
        log.trace("constructor() is called");
}



    public static ProcessorsModel getProcessorsModel(int id) {
        log.trace("getProcessorsModel() is called");
        log.debug("getting Processors Model for id=" + id);
        Optional<ProcessorEntity> result = processorsRepository.findById(id);
        if(result.isPresent()){
            ProcessorsModel form = new ProcessorsModel();
            ProcessorEntity processor = result.get();
            copyEntityToModel(processor, form);
            log.debug("the form for id={} is retrieved", id);
            return form;
        }
        log.debug("the form for id={} is not found", id);
        return null;
    }

    private Optional<ProcessorEntity> findById(int id) {
    return null;
    }

    private static void copyEntityToModel(ProcessorEntity student, ProcessorsModel form) {
    }

}
