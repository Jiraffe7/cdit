package gov.tech.cdit.controllers;

import gov.tech.cdit.entities.UrlEntry;
import gov.tech.cdit.repositories.ShorterRepository;
import gov.tech.cdit.util.HashUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/short")
public class ShorternerController {

    private ShorterRepository shorterRepository;
    private String domain;

    public ShorternerController(ShorterRepository shorterRepository,
                                @Value("${short.domain}") String domain) {
        this.shorterRepository = shorterRepository;
        this.domain = domain;
    }

    @GetMapping("/encode")
    @ResponseBody
    public String getShortUrl(@RequestParam(name = "url") String url) {
        System.out.println(url);
        String hash = HashUtil.getSHA(url);
        UrlEntry entry = new UrlEntry(hash, url);
        shorterRepository.save(entry);
        return String.format("%s/%s", domain, hash);
    }

    @GetMapping("/decode")
    public String getLongUrl(@RequestParam(name = "url") String url) {
        String[] parts = url.split("/", -1);
        String hash = parts[parts.length - 1];
        return shorterRepository.findById(hash)
                .map(UrlEntry::getUrl)
                .orElse("error");
    }
}
