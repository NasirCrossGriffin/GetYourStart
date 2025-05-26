import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";

@Component({
    selector : "landingpage-app",
    templateUrl : "./landingpage.component.html",
    styleUrls : ["./landingpage.component.css"],
    imports : [ CommonModule ],
    standalone : true
})

export class LandingPageComponent {
    firstSectionIntersecting : boolean = false
    secondSectionIntersecting : boolean = false
    thirdSectionIntersecting : boolean = false
    observer : any = null

    getFirstSection() {
        const landingpage = document.getElementsByClassName("LandingPage").item(0)
        const firstSection = landingpage?.firstElementChild
        return firstSection
    }

    getSecondSection() {
        const firstSection = this.getFirstSection()
        const secondSection = firstSection?.nextElementSibling
        return secondSection
    }

    getThirdSection() {
        const secondSection = this.getSecondSection()
        const thirdSection = secondSection?.nextElementSibling
        return thirdSection
    }

    ngAfterViewChecked() {
        if (this.observer === null) {
            console.log(this.getFirstSection())
            console.log(this.getSecondSection())
            console.log(this.getThirdSection())
            if (this.getFirstSection() !== null && this.getSecondSection() !== null && this.getThirdSection() !== null) {       
                this.observer = new IntersectionObserver((entries, observer) => {
                    entries.forEach((entry) => {
                        if (entry.isIntersecting) {
                            console.log(entry.target)
                            if (entry.target === this.getFirstSection()) {
                                this.firstSectionIntersecting = true
                                console.log(this.firstSectionIntersecting)
                            }

                            if (entry.target === this.getSecondSection()) {
                                this.secondSectionIntersecting = true
                            }

                            if (entry.target === this.getThirdSection()) {
                                this.thirdSectionIntersecting = true
                            }
                        }

                        if (!(entry.isIntersecting)) {
                            if (entry.target === this.getFirstSection()) {
                                this.firstSectionIntersecting = false
                            }

                            if (entry.target === this.getSecondSection()) {
                                this.secondSectionIntersecting = false
                            }

                            if (entry.target === this.getThirdSection()) {
                                this.thirdSectionIntersecting = false
                            }
                        }
                    })
                }, {
                    threshold : 0.5
                })

                this.observer.observe(this.getFirstSection())
                this.observer.observe(this.getSecondSection())
                this.observer.observe(this.getThirdSection())

                console.log("Observer established")
            }
        }
    }
}