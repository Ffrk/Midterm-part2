package com.ziwei.midtermpart2.Controller;

import com.ziwei.midtermpart2.model.ProcessorsModel;
import com.ziwei.midtermpart2.service.ProcessorDataService;
import io.micrometer.common.util.internal.logging.InternalLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProcessorsController {

    private static final String[] factures = {
            "--- Select ManuFacture ---",
            "Intel", "AMD", "Apple"};
    private final ProcessorDataService processorDataService;
    private InternalLogger log;
    private Object ProcessorsModel;

    public ProcessorsController(ProcessorDataService processorDataService) {
        this.processorDataService = processorDataService;
    }

    @GetMapping(value={"/", "/Input"})
    public String Input(){
        log.trace("Input() is called");
        return "Input";
    }
    Logger logger = LoggerFactory.getLogger(ProcessorsController.class);
    @GetMapping(value={"/","/Input"})
    public ModelAndView Input(Model model){
        log.trace("Input() is called");
        ModelAndView modelAndView =
                new ModelAndView("Input",
                        "form", new ProcessorsModel());
        modelAndView.addObject("programs", factures);
        return modelAndView;
    }

  @GetMapping("/Output")
  public String Output(@PathVariable(name = "id") String strId, Model model){
        log.trace("confirmInsert() is called");
        log.debug("id = " + strId);
         {
            int id = Integer.parseInt(strId);
            log.trace("looking for the data in the database");
             ProcessorsModel form = ProcessorDataService.getProcessorsModel(id);
             if (form == null) {
                log.trace("showing the data");
                model.addAttribute("form", ProcessorsModel);
                return "Output";
            }
        }

      return strId;
  }
}
