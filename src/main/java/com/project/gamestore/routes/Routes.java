package com.project.gamestore.routes;

public class Routes {
    public static final String API_ROOT = "/api";

    public static final String USERS_ROOT = API_ROOT + "/users";
    public static final String USERS_ENTRY = USERS_ROOT + "/{publicIdentifier}";
    public static final String USERS_ENTRY_GAMES = USERS_ENTRY + "/games";

    public static final String GAMES_ROOT = API_ROOT + "/games";
    public static final String GAMES_ENTRY = GAMES_ROOT + "/{publicIdentifier}";
    public static final String GAMES_ENTRY_USERS_ENTRY = GAMES_ENTRY + "/users/{userIdentifier}";
    public static final String GAMES_BUY = GAMES_ENTRY_USERS_ENTRY + "/buy";
    public static final String GAMES_REFUND = GAMES_ENTRY_USERS_ENTRY +"/refund";

    public static final String GENRES_ROOT = API_ROOT + "/genres";
    public static final String GENRES_ENTRY = GENRES_ROOT + "/{publicIdentifier}";

    public static final String PUBLISHERS_ROOT = API_ROOT + "/publishers";
    public static final String PUBLISHERS_ENTRY = PUBLISHERS_ROOT + "/{publicIdentifier}";
    public static final String PUBLISHERS_ENTRY_GAMES = PUBLISHERS_ENTRY + "/games";

    public static final String REVIEWS_ROOT = API_ROOT + "/reviews";
    public static final String REVIEWS_ENTRY = REVIEWS_ROOT + "/{publicIdentifier}";

    public static final String USER_GAMES_ROOT = API_ROOT + "/user_game";
    public static final String USER_GAMES_ENTRY = USER_GAMES_ROOT + "/{publicIdentifier}";

}
