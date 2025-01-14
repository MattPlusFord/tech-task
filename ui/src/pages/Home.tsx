import HeroCard from "../components/cards/HeroCard.tsx";
import './home.css';
import {useEffect, useState} from "react";
import UserClient from "../api/userClient.ts";
import Card from "../components/cards/Card.tsx";
import {useSearchParams} from "react-router-dom";

type User = {
    id: string;
    name: string;
    email: string;
}

export const HomePage = () => {
    const [user, setUser] = useState<undefined|User>();
    const [queryParams] = useSearchParams();
    const [userId] = useState(queryParams.get('uid'));
    const [userLoadError, setUserLoadError] = useState<boolean>(false);
    const userApi = new UserClient();

    useEffect(() => {
        if (!user && userId) {
            userApi.loadUser(userId).then(userData => {
                if (userData) {
                    setUser(userData);
                } else {
                    setUserLoadError(true);
                }
            });
        }
    }, [user]);

    if (user) {
        return (
            <div className="home">
                <HeroCard userName={user?.name ? user.name : ""} />
            </div>
        );
    } else if (!userId || userLoadError) {
        return (
            <div className="home">
                <Card>
                    <h1>Sorry, we've been unable to find your user account</h1>
                </Card>
            </div>
        );
    } else {
        return (
            <div className="home">
                <Card>
                    <h1>Loading</h1>
                </Card>
            </div>
        );
    }
}

export default HomePage;