import apiUtils from "../util/apiUtils";


const Turniri = {

    getAllSezoni: () => {
        return apiUtils.get("/sezoni");
    },

    getTurniriForSezona: (idSezona) => {
        return apiUtils.get("/sezoni/"+idSezona+"/turniri")
    },

    getTurnir: (idTurnir, idKategorija) => {
        return apiUtils.get(`/turniri/${idTurnir}/${idKategorija}`)
    }

};

export default Turniri;