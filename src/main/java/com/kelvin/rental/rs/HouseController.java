package com.kelvin.rental.rs;


import com.kelvin.api.service.RsRepositoryService;
import com.kelvin.rental.model.House;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.kelvin.rental.managment.AppConstants.HOUSES_PATH;

@RestController
@RequestMapping(HOUSES_PATH)
public class HouseController extends RsRepositoryService<House, String> {

    public HouseController() {
        super(House.class);
    }

    @Override
    protected String getDefaultOrderBy() {
        return "created_date desc";
    }

    @Override
    public void applyFilters() throws Exception {

        if (nn("like.created_by")) {
            getEntityManager().unwrap(Session.class).enableFilter("like.created_by").setParameter("created_by", likeParamToLowerCase("like.created_by"));
        }
    }

    @Override
    protected void prePersist(House object) throws Exception {
    }
}
