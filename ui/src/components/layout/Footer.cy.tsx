import Footer from "./Footer.tsx";

describe("Footer", () => {
    describe("displays correctly", () => {
        beforeEach(() => {
            cy.mount(<Footer />)
        });

        it("should show the copyright notification", () => {
            cy.get("p").contains("©Fawd Credit Europe 2025");
        });
    });
});
