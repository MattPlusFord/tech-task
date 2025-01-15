import {useEffect, useState} from "react";
import {Finance} from "../../types/finance.ts";
import UserClient from "../../api/userClient.ts";
import FinanceClent from "../../api/financeClent.ts";
import FinanceCard from "../cards/FinanceCard.tsx";
import Card from "../cards/Card.tsx";
import './accountList.css';

type AccountListProps = {
    userId: string;
}


export const AccountList = ({userId}: AccountListProps) => {
    var [accounts, setAccounts] = useState<undefined|Finance[]>();
    const [accountLoadError, setAccountLoadError] = useState(false);
    const accountsApi = new FinanceClent();

    useEffect(() => {
        if (!accounts && userId) {
            accountsApi.loadFinanceForUser(userId).then(accountData => {
                if (accountData) {
                    setAccounts(accountData);
                } else {
                    setAccountLoadError(true);
                }
            });
        }
    }, [accounts, userId]);

    if (accounts) {
        return (
            <div className="account-list">
                {accounts.map(account => {
                    return <FinanceCard key={account.id} id={account.id} balance={account.balance} interest_rate={account.interestRate} />
                })}
            </div>
        );
    } else if (accountLoadError) {
        return (
            <div className="account-list">
                <Card>
                    <h1>Sorry, we've been unable to find your finance accounts</h1>
                </Card>
            </div>
        );
    } else {
        return (
            <div className="account-list">
                <Card>
                    <h1>Loading</h1>
                </Card>
            </div>
        );
    }
}
