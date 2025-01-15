import {User} from "./users.ts";

export type Finance = {
    id: string;
    user: User;
    balance: number;
    interestRate: number;
}

export type FinanceCardProps = {
    id: string;
    balance: number;
    interest_rate: number;
}
