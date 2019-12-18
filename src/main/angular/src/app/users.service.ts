import { Injectable } from '@angular/core';
// import { ServerConfiguration } from '../services/ServerConfiguration';
import { User } from '../models';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class UsersService {
    constructor(
        private http: HttpClient,
        // private config: ServerConfiguration
    ) { }
    /**
     * Récupère tous les posts
     * @param channelId le channel concerné
     */

}
